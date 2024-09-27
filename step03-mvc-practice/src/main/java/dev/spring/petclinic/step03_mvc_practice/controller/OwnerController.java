package dev.spring.petclinic.step03_mvc_practice.controller;

import dev.spring.petclinic.step03_mvc_practice.model.Owner;
import dev.spring.petclinic.step03_mvc_practice.repository.OwnerRepository;
import dev.spring.petclinic.step03_mvc_practice.service.OwnerService;
import dev.spring.petclinic.step03_mvc_practice.service.OwnerServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

// Owner와 관련된 처리용 컨트롤러 클래스
// Owner - PetClinic에서 Pet들을 소유한 반려동물 주인

@RequestMapping("/owners") // localhost:8080/owners/*의 요청에 대한 모든 경로 처리
@Controller
@RequiredArgsConstructor // Lombok으로 생성자 메서드 자동 생성
@Slf4j // Lombok에서 제공하는 Logging Annotation, 별도의 Logger 객체를 생성하지 않고, log.info()와 같이 사용 가능
public class OwnerController {
    private static final String VIEWS_OWNER_CREATE_OR_UPDATE_FORM = "owners/createOrUpdateOwnerForm";
    private final OwnerService ownerService;

    @GetMapping("/find") // lh:80/owners/find 요청에 대한 처리
    public String findOwners(Model model) {
        model.addAttribute(Owner.builder().build()); // findOwners.html에서 사용할 모델 데이터
        // 비어있는 Empty Owner 객체를 바인딩해서 예외가 발생하지 않도록 전달
        return "owners/findOwners";
    }

    @GetMapping // class레벨에 작성된 루트 경로인 GET:lh:80/owners로 동작
    public String processFindForm(Owner owner, Model model) {
        if (owner.getLastName() == null) {
            owner.setLastName("");
        }

        List<Owner> results
                = ownerService.findAllOwnersByLastNameLike("%" + owner.getLastName() + "%");

        // Model 데이터에 ownerList.html에서 사용할 데이터 바인딩
        if (results.isEmpty()) { // lastName에 해당하는 owner가 1명도 없을 경우,
            return "owners/findOwners";
        } else if (results.size() == 1) { // owner가 1명일 경우,
            owner = results.get(0);
            return "redirect:/owners/" + owner.getId();
        } else { // owner가 2명 이상일 경우,
            model.addAttribute("listOwners", results);
            return "owners/ownersList";
        }
    }

    @GetMapping("{ownerId}") // owners/3 or owners/13...
    public ModelAndView showOwner(@PathVariable Long ownerId) { // Path - URL의 경로(에 작성된 변수)
        log.info("ownerId = " + ownerId);

        // DB에서 특정 id에 해당하는 Owner 객체 조회
        Owner owner = ownerService.findById(ownerId);

        ModelAndView mnv = new ModelAndView();
        mnv.setViewName("owners/ownerDetails");
        mnv.addObject(owner);

        return mnv;
    }

    @GetMapping("/new")
    public String initCreationForm(Model model) {
        model.addAttribute("owner", Owner.builder().build());
        return VIEWS_OWNER_CREATE_OR_UPDATE_FORM;
    }

    @PostMapping("/new")
    public String processCreationForm(Owner owner) {
        System.out.println("owner = " + owner);
        Owner savedOwner = ownerService.save(owner);
        return "redirect:/owners/" + savedOwner.getId();
    }

    @GetMapping("/{ownerId}/edit")
    public String initUpdateOwnerForm(@PathVariable Long ownerId, Model model) {
        model.addAttribute(ownerService.findById(ownerId));
        return VIEWS_OWNER_CREATE_OR_UPDATE_FORM;
    }

    @PostMapping("/{ownerId}/edit")
    public String processUpdateOwnerForm(Owner owner, @PathVariable Long ownerId) {
        Owner updatedOwner = ownerService.update(owner, ownerId);
        return "redirect:/owners/" + updatedOwner.getId();
    }
}
