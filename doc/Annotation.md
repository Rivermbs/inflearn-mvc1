# Annotation 정리
### 1. @AfterEach == @After
 - 현재 클래스의 각 @Test, @RepeatedTest, @ParameterizedTest 또는 @TestFactory 메소드 이후에 메소드가 실행되어야 함을 의미
 - 테스트가 실패해도 수행됨
 - @AfterEach가 지정된 메소드는 테스트 클래스 내의 각 테스트 메소드 실행 후에 자동으로 실행됨