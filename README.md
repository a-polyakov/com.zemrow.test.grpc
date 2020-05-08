# Иследование протоколов сообщений

Изначальная идея 

Приложение состоит из двух частей сервер и клиент

Сервер java приложение

Клиент html+javascript

Клиентская форма "Chat" состоит из: история переписки, поле ввода сообщения, кнопка отправки

Сервер принимает подключения и полученные сообщения перенаправляет всем подключенным клиентам 

# Test gRPC 

Пример приложения с использование [gRPC](https://grpc.io/)

Сервер базируется на сгенерированом коде `build\generated\source\proto\main\grpc\com\zemrow\test\grpc\ChatGrpc.java`

Генерация происходит на основе `src\main\proto\testgrpc.proto`

За генерацию отвечает [protobuf-gradle-plugin](https://github.com/google/protobuf-gradle-plugin)

Сервер (`com.zemrow.test.grpc.RunTestGrpc`) принимает подключения и перенаправляет в сервис (`com.zemrow.test.grpc.ChatGrpcImpl`)  

Код клиента также генерируется на основе `src\main\proto\testgrpc.proto` с помощью [grpc-web](https://github.com/grpc/grpc-web)

Как оказалось браузер не поддерживает gRPC и не дает JS использовать http 2, 
по этому появился grpc-web это немного другой протокол (поверх старого http 1 и доступного во всех браузерах JS XHR)
соответственно этот протокол не поддерживается сервером, а для взаимодействия клиента и сервера необходима 
дополнительноя конвертации - нужен дополнительный прокси сервер !!!!

Пример не работает, так как изначально узучал эту технологию для отхода от зоопарка технологий (протоколов общения) 
как на серверной стороне так и на клиентской стороне. 

# Другие технологии (еще не изучены)
[twirp](github.com/twitchtv/twirp)

[thrift](thrift.apache.org)

[avro](avro.apache.org)

[msgpack.org](msgpack.org)

[OpenAPI](https://github.com/OAI/OpenAPI-Specification)

# Быстрый экскурс во front 

Стильно модно молодежно https://habr.com/ru/company/mailru/blog/340922/
Если в кратце могут понадобиться следующие инструменты

npm - диспетчер пакетов JS, для автоматической загрузки сторонних пакетов, средства запуска задач для автоматизации разных операций в процессе сборки;

[webpack](https://webpack.js.org/guides/development/) - импорт зависимостей в js, сборка проекта в один скрипт;

babel - транспилятор для конвертации в стандартный (поддерживаемый всеми браузерами) JS;



