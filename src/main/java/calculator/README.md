# 기능 요구사항

---

### 1단계 - 문자열 계산기

- [x] 피연산자
    - 숫자 형식이 아니면 예외 발생
- [x] 연산자
    - 사칙 연산 연산자가 아닌 문자를 사용하면 예외 발생
    - 덧셈
    - 뺄셈
    - 곱셈
    - 나눗셈 (결과 값을 정수로 떨어지는 값으로 한정)
- [x] 문자열 계산식 파싱
    - null 이거나, 빈 문자열인 경우 예외 발생
    - 빈 공백 문자열로 피연산자와 연산자들을 분리
- [x] 계산식
    - 연산 요소의 총 개수는 짝수일 수 없다.
    - 피연산자 또는 연산자가 연속되어 존재할 수 없다.
    - 피연산자, 연산자 순서로 반복된다.
    - 즉 숫자로 시작하고 숫자로 끝난다.
    - 우선순위가 아닌 입력 값에 따라 계산 순서가 결정
