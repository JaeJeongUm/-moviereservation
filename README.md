서비스 시나리오
기능적 요구사항
고객이 영화를 예매한다. (영화 종류 , 극장, 시간, 인원)
고객이 결제 한다.
예매가 완료되면, 예매 예약내용을 해당 AP 알림을 보낸다.
영화 관람 10분전 상영 시작을 알리는 알림을 보낸다.
고객이 예매를 취소한다 .
고객이 주문상태를 중간에 조회한다.
사진 설명을 입력하세요.

Event Storming
이벤트 도출 및 부적격 이벤트 탈락
사진 설명을 입력하세요.
사진 설명을 입력하세요.
//예매하기
사진 설명을 입력하세요.
//gateway 포트인 8088로 apigateway로 접속
사진 설명을 입력하세요.

//paymnet Policy (kafka)
사진 설명을 입력하세요.
//ticket Policy(kafka)
사진 설명을 입력하세요.
//Inventory 재고량없을경우 보상처리
사진 설명을 입력하세요.
//Azure Client SSO 설정
az login --use-device-code

//클러스터가져오기 (Target AKS cluster)
az aks get-credentials --resource-group user19-rsrcgrp --name user19-aks

//AKS worknode 확인
kubectl get all
kubectl get node

//AKS와 ACR 바인딩
az aks update -n user19-aks -g user19-rsrcgrp --attach-acr user19
사진 설명을 입력하세요.

//계정 정보 및 구독 정보 확인
사진 설명을 입력하세요.
//Azure AC Login
az acr login --name (REGISTRY_NAME) --expose-token
사진 설명을 입력하세요.
//카프카 설치
Linux : Helm 3.x 설치
curl https://raw.githubusercontent.com/helm/helm/master/scripts/get-helm-3 > get_helm.sh chmod 700 get_helm.sh ./get_helm.sh

helm으로 Kafka 설치
helm repo add bitnami https://charts.bitnami.com/bitnami helm repo update helm install my-kafka bitnami/kafka --version 23.0.5


//ACR에 이미지 빌드 및 푸시
docker build -t user19.azurecr.io/reserve:v1 .
docker push user19.azurecr.io/reserve:v1


//각 서비스 클라우드 배포
mvn package -B -Dmaven.test.skip=true
사진 설명을 입력하세요.
//ACR에 도커라이징 확인
사진 설명을 입력하세요.
사진 설명을 입력하세요.


//kafka 설치
kubectl get all
kubectl get svc,deploy
사진 설명을 입력하세요.


//각 서비스 배포
kubectl apply -f kubernetes/deployment.yaml
kubectl apply -f kubernetes/service.yaml
사진 설명을 입력하세요.

//서비스갯수 조절 레플리카
kubectl scale deploy order --replicas=3 # 주문서비스가 3개로 확장된다. kubectl scale deploy order --replicas=1
사진 설명을 입력하세요.

seige 및 hpa 설정
사진 설명을 입력하세요.
사진 설명을 입력하세요.
//PVC
//볼륨 생성
사진 설명을 입력하세요.
//pvc Bound(연결된상태)
사진 설명을 입력하세요.
//Redis container와 nginx container에서의 PVC를 통한 파일 공유
사진 설명을 입력하세요.
사진 설명을 입력하세요.


//Liveness 테스트
//직접 reserve POD를 delete후에 다시 살아남
사진 설명을 입력하세요.



