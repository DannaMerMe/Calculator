# Calculator 

### Author
Danna Xiomara Merchán Mesa
2024 Noviembre

## Description

This project returns a results of operations between number with the following endpoint:

1. `animal/division?dividend={number}&divider{number}`   
   Returns result of division.
2.  `http://localhost:8081/animal/loga?number{number}`
   Returns the logarithm of the number.
3.  `http://localhost:8081/animal/power?base{number}&exponent{number}`
   Returns the power or the number

## use endpoint

Example 1: 
`http://localhost:8081/animal/division?dividend=11.01&divider=2`
Example 2: 
`localhost:8081/animal/loga?number=10`
Example 3
`http://localhost:8081/animal/power?base=2&exponent=8`


## Compilation

```
mvn clean install
```

## package jar
```
mvn clean package
```
