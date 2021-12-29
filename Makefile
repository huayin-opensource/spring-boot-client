ACR_REGION = registry.cn-shenzhen.aliyuncs.com
ACR_NAMESPACE = kubeops
NAME = spring-boot-client
TAG = latest

IMAGE = $(ACR_REGION)/$(ACR_NAMESPACE)/$(NAME):$(TAG)

.PHONY: all
all: build-image push-image

.PHONY: build-image
build-image:
	docker build -t $(IMAGE) .

.PHONY: push-image
push-image:
	docker push $(IMAGE)
