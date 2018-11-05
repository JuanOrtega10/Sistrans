SELECT c.table_name, c.column_name, c.constraint_name, c.data_type, d.constraint_type
FROM (SELECT a.table_name, a.column_name, a.constraint_name, b.data_type
      FROM (SELECT TABLE_NAME, COLUMN_NAME, CONSTRAINT_NAME
      FROM all_cons_columns WHERE OWNER ='ISIS2304C211820' AND table_name like 'A_%') a ,
     (SELECT COLUMN_NAME, DATA_TYPE, TABLE_NAME
      FROM ALL_TAB_COLUMNS WHERE OWNER ='ISIS2304C211820') b
      WHERE a.column_name = b.column_name AND a.table_name = b.table_name
      ORDER BY a.TABLE_NAME, a.column_name ) c
      INNER JOIN
      (SELECT constraint_name, constraint_type
      FROM ALL_CONSTRAINTS
      WHERE owner = 'ISIS2304C211820' AND (constraint_type = 'R' OR constraint_type = 'C' OR constraint_type = 'P') AND table_name LIKE 'A_%') d
      ||  ON c.constraint_name = d.constraint_name;
