### Hexlet tests and linter status:
[![Actions Status](https://github.com/Lunycat/java-project-71/actions/workflows/hexlet-check.yml/badge.svg)](https://github.com/Lunycat/java-project-71/actions)
[![Maintainability](https://api.codeclimate.com/v1/badges/e1a569359340e85ff88d/maintainability)](https://codeclimate.com/github/Lunycat/java-project-71/maintainability)
[![Test Coverage](https://api.codeclimate.com/v1/badges/e1a569359340e85ff88d/test_coverage)](https://codeclimate.com/github/Lunycat/java-project-71/test_coverage)
[![Java CI](https://github.com/Lunycat/java-project-71/actions/workflows/main.yml/badge.svg)](https://github.com/Lunycat/java-project-71/actions/workflows/main.yml)

# Описание
Вычислитель отличий – программа, определяющая разницу между двумя структурами данных. Это популярная задача, для решения которой существует множество онлайн-сервисов, например: http://www.jsondiff.com/. Подобный механизм используется при выводе тестов или при автоматическом отслеживании изменении в конфигурационных файлах.

## Возможности утилиты:

+ Поддержка разных входных форматов: yaml и json
+ Генерация отчета в виде plain text, stylish и json

## Пример использования:

```
# формат plain
./app --format plain path/to/file.yml another/path/file.json

Property 'follow' was added with value: false
Property 'baz' was updated. From 'bas' to 'bars'
Property 'group2' was removed

# формат stylish
./app filepath1.json filepath2.json

{
  + follow: false
  + numbers: [1, 2, 3]
    setting1: Value 1
  - setting2: 200
  - setting3: true
  + setting3: {key=value}
  + setting4: blah blah
}
```

1) Сравнение .json и .yaml форматов на [asciinema](https://asciinema.org/a/jT407JCZaA1pHbggllm9IV7Mw)
2) Сравнение вложенных файлов на [asciinema](https://asciinema.org/a/vLbOpBsGjgzwwv3Vzlee5vGOi)
3) Выбор формата plain на [asciinema](https://asciinema.org/a/u0Ahn1yXnMInpMSQa6ThjWdHg)
4) Выбор формата json на [asciinema](https://asciinema.org/a/LY2tAFDmpt0Lt0Y8CoDPpVe1T)
