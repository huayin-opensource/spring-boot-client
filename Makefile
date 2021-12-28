ACR_REGION = registry.cn-shenzhen.aliyuncs.com
ACR_NAMESPACE = kubeops
NAME = spring-boot-client
TAG = latest

IMAGE = $(ACR_REGION)/$(ACR_NAMESPACE)/$(NAME):$(TAG)

build-image:
	docker build -t $(IMAGE) .

push-image:
	docker push $(IMAGE)
