Functional requirements
1. conditionalExpression should be able to support any infix expression
2. Supported operators >, >=, <=, <, ==, !=, BETWEEN, ALLOF, NONEOF
3. Datatypes supported numbers, string, boolean
4. Module should be extensible to allow new attributes and new operators without major changes


How to use Gating Validator:

1. For allof , noneof operators values should be comma separated string
    eg: visitedplaces allof mumbai,delhi,bangalore
2. For "or" , "and" operators boolean values expected
3. For lessThan, lessThanEqualsTo, greaterThan, greaterThanEqualsTo, Between operators integer values expected
4. For equalsTo, notEqualsTo operator String and Integer and Boolean values supported
5. You can use Round braces also "(" ")"
6. All values , operators, attributes name, braces should be space separated.


Extending Gating Validator functionality  and flexibility:

Few Assumptions/Facts;
1. Expression is always be represent as string type so it means operands in expression are always be string type.
2. How to figure out data type ?
    Basically we are passing map with generic type Object in user attributes. But actual we are passing values
    as  either Integer/Double/String/Boolean or can be extend custom class. So we will use chain of responsiblity design
    pattern to handle the data type . If in chain of responsiblity no one match then we will throw UnsupportedOperationException.