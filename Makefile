IMAGE_NAME=spring-actuator-example

clean:
	@./mvnw clean
	@echo "Done!"

build: clean
	@./mvnw package
	@echo "Done!"
	@docker build -t ${IMAGE_NAME} .
	
release:
# TODO: deixar processo de release (com config) melhor padronizado de acordo com 12-factor

run:
	@docker run -p 8080:8080 ${IMAGE_NAME}
