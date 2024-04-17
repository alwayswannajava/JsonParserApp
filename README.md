# JsonParserApp
# Context description 
 Our context contains two entities which connect with each other by many to one connection. 
 The first one entity is student. Student has the following fields: student_id, group_id, 
 courses, first_name, last_name.
 The second one entity is group. Group has the following fields: group_id, group_name.
 
# Input data example 
  This parser accepts two parameters. 
  The first parameter - path to directory where json files storing. It works for both absolute and relative paths.
  The second parameter - attribute by which parsing will be performed.
  Input data example: 

  ![image](https://github.com/alwayswannajava/JsonParserApp/assets/104648050/55897ab3-2a46-41fc-86a4-3200404a44cd)

  
# Output data example 
  Output contains xml file with statistics by input attribute(second parameter).
  Output xml file will be stored in directory which was input by the first one parameter. 
  For example, if input dir was: src/main/resources, so result statistics xml file will 
  be in this one directory.
  Output xml file example:

  ![image](https://github.com/alwayswannajava/JsonParserApp/assets/104648050/aa9b91ed-f0ec-4bbb-8d87-7bf16ef92fca)

# Multithreading experiment
  There was experiment with threads. 
  
| Records  | Time  | Threads |
| :------------ |:---------------:| -----:|
| 250      | 2 sec 125 ms | 1 |
| 250      | 2 sec 123 ms | 2 |
| 250      | 1 sec 003 ms | 4 |
| 250      | 253 ms | 8 |
| 500      | 2 sec 567 ms | 1 |
| 500      | 1 sec 107 ms        |   2 |
| 500 | 1 sec       |    4 |
| 500      | 338 ms | 8 |


  
