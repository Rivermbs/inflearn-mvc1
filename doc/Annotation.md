# Annotation 정리
### 1. @AfterEach == @After
 - 현재 클래스의 각 @Test, @RepeatedTest, @ParameterizedTest 또는 @TestFactory 메소드 이후에 메소드가 실행되어야 함을 의미
 - 테스트가 실패해도 수행됨