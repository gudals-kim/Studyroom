
# [백준 10930번 SHA-256](https://www.acmicpc.net/problem/10930)

## <img src="https://raw.githubusercontent.com/gudals-kim/Studyroom/3e53104ae0a7a0f6bdc6bd42d7e228dcfd89d937/codingtest/img/rank/unrank.svg" width="20"> 백준 10930번 SHA-256

| 시간제한 |메모리제한| 정답비율 |   난이도    |
|:----:|:---:|:----:|:--------:|
|  1초  |256MB| 76%  | unRanked |

<br>

### 문제

```
[문제]
문자열 S가 주어졌을 때, SHA-256 해시값을 구하는 프로그램을 작성하시오.

[입력]
첫째 줄에 문자열 S가 주어진다.
S는 알파벳 대문자와 소문자, 그리고 숫자로만 이루어져 있으며, 길이는 최대 50이다.

[출력]
첫째 줄에 S의 SHA-256 해시값을 출력한다.

```


<br>

|예제입력|예제출력|
|:---:|:---:|
|Baekjoon|9944e1862efbb2a4e2486392dc6701896416b251eccdecb8332deb7f4cf2a857|



<br>

### 문제풀이 전략


- hashlib 라이브러리 사용



### 답안 전체코드

```py
import hashlib

print(hashlib.sha256(input().encode()).hexdigest())

```
