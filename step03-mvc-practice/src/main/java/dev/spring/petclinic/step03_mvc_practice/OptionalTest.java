package dev.spring.petclinic.step03_mvc_practice;

import java.util.Optional;

public class OptionalTest {
    public static void main(String[] args) {
        // Optional

        // Optional 객체 생성

        // 1. of(): null이 아닌 값으로 Optional을 생성할 때 사용
        Optional<String> optWitValue = Optional.of("value값");
        System.out.println(optWitValue); // Optional[value값] -> Optional 객체로 값이 감싸져 있음

        String str = optWitValue.get(); // Optional 객체 내 값이 있는 것을 확신할 수 있을 때, Optional 내의 값을 꺼내는 메서드
        System.out.println("str = " + str);

        // Optional 객체 내 값이 있는지 없는지 확인
        System.out.println(optWitValue.isPresent()); // 그 외 isEmpty()

        // Optional 객체 내에 값이 있을 경우에 다른 처리가 필요할 때 - if-else
        optWitValue.ifPresent(value -> doSome(value)); // if (value != null) doSome(value);와 같음
        // optWitValue.ifPresentOrElse();

        // Optional 내에 값이 없을 때, 다른 값으로 대체하여 사용할 때 (orElse, OrElseGet)
        Optional<String> optWithEmpty = Optional.empty(); // 내부에 별도의 값이 없는 Optional 객체
        String result = optWithEmpty.orElse("default value"); // value에 값이 없으면 "default value"로 대체
        System.out.println("result = " + result);

        // orElseThrow(), 값이 없으면 예외 던지기, 값이 있으면 해당 값을 반환
        String result2 = optWitValue.orElseThrow();
        System.out.println("result2 = " + result2);

//        String result3 = optWithEmpty.orElseThrow();
//        System.out.println("result3 = " + result3); // 값이 없기 때문에 NoSuchElementException 예외 발생

        // 별도의 (커스텀) 예외를 지정하고 싶을 경우,
        String result4 = optWithEmpty.orElseThrow(() -> new RuntimeException("값이 없는데요?"));
        System.out.println("result4 = " + result4);
    }

    public static void doSome(String value) {
        System.out.println("value와 관련된 처리 작업 수행");
    }
}
