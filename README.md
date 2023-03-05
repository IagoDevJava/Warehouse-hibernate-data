# Warehouse
#### *"Ware? Where? Warehouse!"*


## Это репозиторий проекта "WWW"
#### Проект Склад (Java EE, Spring, Hibernate, SQL), с добавленным функционалом для контейнеризации через Docker. Архитектура монолитная, подключена БД с помощью Hibernate ORM, PostgreSQL. Клиент-серверная структура на основе REST. Проект собран на Maven. Использован JUnit 5, для тестирования функционала.

Pet-project № 2
#### Приложение создано для составления списка покупок и контроля наличия продуктов дома. Планируется создать две версии приложения - для smart-холодильника и для мобильной ручной версии.

Поставленные задачи:
- [ ] Архитектура:
	 - [ ] Контроль товаров
	 - [ ] Список покупок
	 - [ ] Сервис статистики
- [ ] Создать БД Создать и сохранить диаграмму <!-- подкрутить app.prop-->
- [ ] Подготовить файлы для Docker
- [ ] Внести в БД список основных продуктов
- [ ] Создать эндпойнты, согласно REST:
	- [ ] Список покупок:
		- [ ] Получить список по умолчанию <!-- /shoppinglist/GET -->
		- [ ] Редактировать список по умолчанию <!-- /shoppinglist/PATCH -->
		- [ ] Создать пользовательский список:
			- [ ] Добавить продукт <!-- /shoppinglist/custom/productId/POST -->
			- [ ] Удалить продукт <!-- /shoppinglist/custom/productId/DELETE -->
			- [ ] Получить пользовательский список <!-- /shoppinglist/custom/listId/GET -->
			- [ ] Сохранить пользовательский список <!-- /shoppinglist/custom/listId/POST -->
	- [ ] Контроль продуктов:
		- [ ] Добавить купленный продукт <!-- /controlproducts/productId/POST -->
		- [ ] Удалить закончившийся продукт <!-- /controlproducts/productId/DELETE -->
- [ ] Создать функционал DAL
- [ ] Написать автотесты

Приложение написано на Java при помощи Spring и сопутствующих библиотек. Пример кода:

```java
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BankEmployeesSalariesApplication {

    public static void main(String[] args) {
        SpringApplication.run(BankEmployeesSalariesApplication.class, args);
    }

}
```

### Базы данных:
- PG-DB - база-список всех товаров с категориями, подключается к M-DB, для получения цен
- MARKET-DB - база товаров интернет-магазина. Товары, категории, цены.
- PL-DB - база с таблицами мест, куда складывает товары при покупке, подключается к PG-DB для получения товаров
- SL-DB - база списков покупок, подключается к PG-DB для получения товаров
- S-DB - база статистики покупок, подключается к M-DB, для получения цен, к PG-DB для получения товаров и PL-DB для получения дат

#### ER-диаграмма базы данных для приложения:

![This is ER-diagramme](warehouse-db.png)

<!-- #### Примеры запросов к базе данных:

Получаем наименование жанров по названиям фильмов:
```
SELECT f.name,
	   g.name
FROM film AS f
JOIN genre AS g ON g.genre_id=f.genre_id 
```
Получаем названия фильмов с рейтингом:
```
SELECT f.name,
	   r.name
FROM film AS f
JOIN rate AS r ON r.rate_id=f.rate_id
```
Получаем количество лайков у фильмов:
```
SELECT f.name,
	   COUNT(l.user_id)
FROM film AS f
JOIN like AS l ON l.film_id=f.film_id
GROUP BY f.name
```
Получаем фильмы, которые нравятся Васе:
```
SELECT u.name,
	   f.name
FROM film AS f
JOIN like AS l ON l.film_id=f.film_id 
JOIN user AS u ON l.user_id=u.user_id
WHERE u.name = 'Vasya'
GROUP BY user_name
```
Получаем пользователей, которым нравится фильм Дюна:
```
SELECT u.name
FROM user AS u
JOIN like AS l ON l.user_id=f.user_id 
JOIN film AS f ON f.film_id=l.film_id
WHERE f.name = 'Dune'
```
Получаем друзей Васи:
```
SELECT f.name
FROM user AS u
JOIN friendly_status AS fs u.user_id=fs.user_id
JOIN friend AS f ON fs.user_id=f.friend_id
WHERE user_name='Vasya'
``` -->
