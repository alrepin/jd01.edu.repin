## 3.4. Введение в SQL
***
### Шаг 1

#### Добавить эндпоинт для получения всех студентов, возраст которых находится в промежутке, пришедшем в запросе
В GET-запросе будут передаваться два числа (`min` и `max`). 
Для этого в репозитории следует создать метод `findByAgeBetween()`.

#### Добавить эндпоинт для поиска факультета по имени или цвету, игнорируя регистр

В GET-запросе будет передана строка, по которой будет происходить фильтрация.

🔥
_Критерии оценки: Созданы два эндпоинта. Первый возвращает студентов, у которых возраст попадает в заданные границы. Второй возвращает факультет по названию или цвету._

### Шаг 2

#### Подключиться с помощью IDEA к базе данных и выполнить простой запрос `select * from student`.

🔥
_Критерии оценки: Подключение установлено, есть возможность просмотреть список таблиц. И как следствие SELECT-запрос возвращает данные о студентах._

### Шаг 3

#### Составить следующие SQL-запросы:

* Получить всех студентов, возраст которых находится между 10 и 20 (можно подставить любые числа, главное, чтобы нижняя граница была меньше верхней).
* Получить всех студентов, но отобразить только список их имен.
* Получить всех студентов, у которых в имени присутствует буква «О» (или любая другая).
* Получить всех студентов, у которых возраст меньше идентификатора.
* Получить всех студентов упорядоченных по возрасту.

#### В корне проекта создать файл scripts.sql и поместить в него составленные запросы.

🔥
_Критерии оценки: В результате должно получиться 5 SQL-запросов, которые выполняют описанные требования. Составленные запросы расположены в файле scripts.sql_

### Шаг 4

Настроить связь `ManyToOne` между студентами и факультетом. При этом у модели студента должно быть создано поле `Faculty`, а у модели факультета — `список студентов`.

#### Добавить два эндпоинта в соответствующие контроллеры которые позволят:

* ##### Получить факультет студента
* ##### Получить студентов факультета

🔥
_Критерии оценки: Настроить связь ManyToOne между студентами и факультетом. В результате в таблице студентов должна появиться колонка  `faculty_id`. Добавлены два эндпоинта, которые позволяют получить студентов факультета и факультет студента._
***