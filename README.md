# 부동맞춤🏡 : 외국인 비대면 부동산 거래 서비스
<div style="display: flex; justify-content: center; gap: 20px;">
  <img src="https://github.com/real-estate-contract/real-estate-front/assets/99604087/13e626fb-4d4a-4817-b554-d465e48baea4" style="border-radius: 15px; width: 20%;">
  <img src="https://github.com/real-estate-contract/real-estate-front/assets/99604087/35142afd-087c-4f25-aebf-211581898571" style="border-radius: 15px; width: 20%;">
    <img src="https://github.com/real-estate-contract/real-estate-front/assets/99604087/233c94c8-4e85-42c9-b1f0-c6326a3682a1" style="border-radius: 15px; width: 20%;">
</div>
<br/>

| 원스톱 비대면 부동산 전자계약 시스템 🏡
- 배포 URL : https://www.budong.kr/
- 한국인(임대인)
    - Test ID : test@gmail.com
    - Test PW : 0000
- 외국인(임차인) 
    - Test ID : foreigner@gmail.com
    - Test PW : 0000

<br>

## 프로젝트 소개 📝

- **부동맞춤**은 매물등록, 검색, 계약, 결제 등 모든 거래 절차를 온라인으로 완료할 수 있는 원스톱 시스템을 제공하여 신속하고 편리한 부동산 거래를 지원합니다.
- 신원확인과 상호확인 과정을 통해 법적 효력이 있는 계약서를 작성할 수 있으며, 계약서는 PDF 형태로 언제든 플랫폼에서 확인 가능합니다.
- 부동맞춤은 기존 플랫폼의 한계를 극복하여 외국인들이 매물 거래를 할 수 있는 장점을 제공합니다.
- 백엔드 소스코드 : https://github.com/real-estate-contract/real-estate-api.git
- 프론트 소스코드 : https://github.com/real-estate-contract/real-estate-front.git
----

<br>

## 팀원 구성 및 역할 👨‍👨‍👧‍👧

<table>
  <tbody>
      <tr>
      <td align="center">백엔드</td> 
      <td align="center">백엔드</td>
      <td align="center">프론트</td>
      <td align="center">프론트</td>
      <td align="center">기획</td>
      </tr>
      <tr>
      <td align="center"><a href="https://github.com/harin1212"><img src="https://github.com/harin1212.png" width="100px;" alt=""/></td>
      <td align="center"><a href="https://github.com/Choi-InHo"><img src="https://github.com/Choi-InHo.png" width="100px;" alt=""/></td>
      <td align="center"><a href="https://github.com/yuujin00"><img src="https://github.com/yuujin00.png" width="100px;" alt=""/></td>
      <td align="center"><a href="https://github.com/doeuni"><img src="https://github.com/doeuni.png" width="100px;" alt=""/></td>
      <td align="center"><a href="https://github.com/C8-H10-N4-O2"><img src="https://github.com/C8-H10-N4-O2.png" width="100px;" alt=""/></td>
      </tr>
      <tr>
      <td align="center"><a href="https://github.com/harin1212">김하린</td> 
      <td align="center"><a href="https://github.com/Choi-InHo">최인호</td> 
      <td align="center"><a href="https://github.com/yuujin00">권유진</td>
      <td align="center"><a href="https://github.com/doeuni">김도은</td>
      <td align="center"><a href="https://github.com/C8-H10-N4-O2">이예솔</td>
      </tr>
    <tr>
    <td align="center">팀장<br/>CI/CD 및 배포<br/>계약, 서명 기능<br/>결제 기능</td> 
    <td align="center">로그인, 회원가입<br/> 매물 기능 <br/> 필터링 기능<br/> 채팅 기능 <br/> </td> 
    <td align="center">회원 페이지<br/> 계약, 서명 페이지 <br/> 결제 페이지<br/> 지도 기능 <br/></td>
    <td align="center">매물 리스트 페이지<br/> 채팅 페이지 <br/> 필터링 기능<br/> </td>
    <td align="center">프로젝트 기획 <br/> 기능 설계 <br/> 디자인 </td>
    </tr>
  </tbody>
</table>


<br>

## 1. 개발 환경

- 프론트 : React
- 백엔드 : Spring Boot + MySQL, MongoDB, Redis, Kafka, QueryDsl
- 인프라 : Jenkins, AWS EC2, S3 ACM, Cloud Front, Route53, Docker, Docker Compose
- 협업 툴 : Discord, Notion, Github
<br>

## 2. 서비스 아키텍처 
####  🏛 Infra - Backend
<img src="https://github.com/real-estate-contract/real-estate-front/assets/99604087/53066bed-88aa-4006-ad2f-5e1cce295966" width="70%"/>

####  🏛 Infra - Frontend
<img src="https://github.com/real-estate-contract/real-estate-front/assets/99604087/adc78aca-a8ff-4142-887c-2127eb40cd25" width="50%"/>

## 3. 페이지별 기능

### 🎥 온보딩, 회원가입, 로그인
- 서비스 접속 초기화면입니다.
- 온보딩 화면 이후 회원가입, 로그인을 진행합니다.

| 기능 | 배포 환경 시연 |
|:----:|:------:|
| 온보딩, 회원가입, 로그인 | <div style="display: flex; justify-content: center; gap: 20px;"><img src="https://github.com/real-estate-contract/real-estate-front/assets/99604087/5d05524d-0255-40a0-bf4d-76a7819994e6" width="30%" style="border-radius: 15px;"/><img src="https://github.com/real-estate-contract/real-estate-front/assets/99604087/538cf4e1-2a1a-415a-8411-691282031081" width="30%" style="border-radius: 15px;"/></div> |

### 🎥 매물 등록
- (1) 주소 등록 : 매물 소유인(임대인)은 플랫폼을 통해 매물을 등록할 수 있습니다. 네이버 클라우드의 지도 API를 이용해 지도 검색 기능으로 매물 주소를 검색 후 등록합니다.
- (2) 매물 옵션 : 임대인이 매물 옵션 정보를 등록합니다.
- (3) 추가 옵션 : 매물에 관해 추가 필요한 정보를 등록합니다.
- (4) 이미지 : 매물 이미지를 등록합니다. 이 때 이미지는 S3 버킷으로 관리합니다.

| 기능 | 배포 환경 시연 |
|:----:|:------:|
| 주소 등록 매물 옵션, 추가 옵션, 이미지 등록 | <div style="display: flex; justify-content: center; gap: 20px; flex-wrap: wrap;"><img src="https://github.com/real-estate-contract/real-estate-front/assets/99604087/11887e26-6f4b-4043-8d10-d874df937025" width="30%" style="border-radius: 15px; margin-bottom: 20px;"/><img src="https://github.com/real-estate-contract/real-estate-front/assets/99604087/9a95d517-d4e2-48f8-a8d1-5beb48a1f644" width="30%" style="border-radius: 15px; margin-bottom: 20px;"/><img src="https://github.com/real-estate-contract/real-estate-front/assets/99604087/281aaef7-0f79-4c50-abb6-6123252db085" width="30%" style="border-radius: 15px; margin-bottom: 20px;"/></div> |

### 🎥 매물 리스트
- 임차인(외국인)은 플랫폼에서 매물 검색을 통해 매물을 검색할 수 있습니다. 
- (1) 원하는 위치나 주소를 통해 인근 매물을 검색할 수 있습니다.
- (2) 필터링을 통해 조건에 맞는 매물을 찾을 수 있습니다. queryDsl에서 제공하는 기능인 BooleanExpression을 활용해 상황, 조건별로 다중 조건을 주어 원하는 매물을 찾아 검색할 수 있습니다.
- (3) 매물보기에서 원하는 매물을 선택해 거래하기 버튼을 누르면 계약을 진행할 수 있습니다. 이 때, 자신의 매물을 자신이 거래하지 못하도록 예외처리를 했습니다

| 기능 | 배포 환경 시연 |
|:----:|:------:|
| 매물 검색 | <div style="display: flex; justify-content: center; gap: 20px;"><img src="https://github.com/real-estate-contract/real-estate-front/assets/99604087/066e6c42-225e-426f-9506-016312d3589a" width="30%" style="border-radius: 15px;"/></div> |

### 🎥 매물 거래 - 전자 계약서
- 임차인(외국인)은 플랫폼에서 매물 검색을 통해 매물을 검색할 수 있습니다. 
- (1) 임차인(외국인)이 원하는 매물을 선택하면 절차를 확인하고 계약을 진행합니다.
- (2) 매물 등록 단계에서 저장한 계약서를 불러와 계약당사자들은 서로 확인합니다.
- (3) 거래 당사자간 수정이 가능한 부동산 단기 월세 계약서를 작성합니다.
- (4) 계약서 동의 후 계약 당사자들은 계약서 작성을 완료합니다.

| 기능 | 배포 환경 시연 |
|:----:|:------:|
| 전자 계약서 작성 | <div style="display: flex; justify-content: center; gap: 20px;"><img src="https://github.com/real-estate-contract/real-estate-front/assets/99604087/029979ad-d215-4586-a098-f076b794b167" width="30%" style="border-radius: 15px;"/></div> |

### 🎥 매물 거래 - 전자 서명
- (1) 계약서 작성을 완료한 뒤, 서명하기를 진행합니다.
- (2) 거래 당사자들 모두 각자 서명을 완료합니다.
- (3) 서명의 진위여부를 확인하고 결제할 수 있습니다.

| 기능 | 배포 환경 시연 |
|:----:|:------:|
| 전자 서명 | <div style="display: flex; justify-content: center; gap: 20px;"><img src="https://github.com/real-estate-contract/real-estate-front/assets/99604087/5934c817-c2ec-4a40-b4c3-96fbec992f59" width="30%" style="border-radius: 15px;"/></div> |

### 🎥 매물 거래 - 결제
- (1) 결제는 KG이니시스의 테스트 환경입니다.
- (2) 금액 확인 후 결제하기를 눌러 결제를 진행합니다.
- (3) 결제 완료 후 계약서를 수령할 수 있습니다.
- (4) 테스트 환경으로 결제 당일 자정에 돈을 다시 환급받을 수 있습니다.

| 기능 | 배포 환경 시연 |
|:----:|:------:|
| 결제 | <div style="display: flex; justify-content: center; gap: 20px;"><img src="https://github.com/real-estate-contract/real-estate-front/assets/99604087/04162101-ddb2-491f-8268-9f1690eec124" width="30%" style="border-radius: 15px;"/></div> |


<br>
