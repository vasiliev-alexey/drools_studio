CREATE TABLE abstract_condition
(
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    code TEXT NOT NULL,
    name TEXT,
    condition_type TEXT
);
CREATE TABLE account_calendar
(
    id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    code VARCHAR2(50) NOT NULL,
    name VARCHAR2(150) NOT NULL
);
CREATE UNIQUE INDEX account_calendar_code_uindex ON account_calendar (code);
CREATE TABLE account_period
(
    id INTEGER PRIMARY KEY NOT NULL,
    code TEXT NOT NULL,
    name TEXT NOT NULL,
    period_num INTEGER NOT NULL,
    start_date TEXT NOT NULL,
    end_date TEXT,
    account_calendar_id INTEGER NOT NULL,
    adjustmentFlag TEXT,
    FOREIGN KEY (account_calendar_id) REFERENCES account_calendar (id)
);
CREATE TABLE chart_of_account
(
    id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    segment1 TEXT DEFAULT '-',
    segment2 TEXT DEFAULT '-',
    segment3 TEXT DEFAULT '-',
    segment4 TEXT DEFAULT '-',
    segment5 TEXT DEFAULT '-',
    segment6 TEXT DEFAULT '-',
    segment7 TEXT DEFAULT '-',
    segment8 TEXT DEFAULT '-',
    segment9 TEXT DEFAULT '-',
    segment10 TEXT DEFAULT '-',
    enabled_flag TEXT,
    start_date DATE,
    end_date DATE
);
CREATE TABLE constant_condition
(
    id INTEGER PRIMARY KEY,
    string_value TEXT,
    double_value DOUBLE,
    date_value DATE,
    constant_value_type TEXT NOT NULL,
    FOREIGN KEY (id) REFERENCES abstract_condition (id) ON DELETE CASCADE ON UPDATE CASCADE
);
CREATE TABLE currency
(
    id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    code TEXT NOT NULL,
    name TEXT NOT NULL
);
CREATE UNIQUE INDEX currency_code_uindex ON currency (code);
CREATE TABLE event
(
    id INTEGER PRIMARY KEY,
    code TEXT,
    name TEXT
);
CREATE UNIQUE INDEX Event_code_uindex ON event (code);
CREATE TABLE model
(
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    code TEXT,
    name TEXT,
    package TEXT
);
CREATE TABLE model_attr
(
    id INTEGER PRIMARY KEY NOT NULL,
    code TEXT NOT NULL,
    name TEXT NOT NULL,
    attr_group_id INTEGER,
    value_type TEXT,
    CONSTRAINT model_attr_1 FOREIGN KEY (attr_group_id) REFERENCES model_attr_group (id) ON DELETE CASCADE
);
CREATE TABLE model_attr_group
(
    id INTEGER PRIMARY KEY,
    model_id INTEGER NOT NULL,
    code TEXT NOT NULL,
    name TEXT NOT NULL,
    group_type TEXT,
    FOREIGN KEY (model_id) REFERENCES model (id) ON DELETE CASCADE
);
CREATE TABLE sqlite_master
(
    type TEXT,
    name TEXT,
    tbl_name TEXT,
    rootpage INTEGER,
    sql TEXT
);
CREATE TABLE sqlite_sequence
(
    name ,
    seq
);