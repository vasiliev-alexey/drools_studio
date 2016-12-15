-- noinspection SqlDialectInspectionForFile

CREATE TABLE abstract_condition
(
    id INTEGER PRIMARY KEY,
    code TEXT NOT NULL,
    name TEXT,
    condition_type TEXT
);
CREATE TABLE constant_condition
(
    id INTEGER PRIMARY KEY,
    string_value TEXT,
    double_value REAL,
    date_value TEXT,
    constant_value_type TEXT NOT NULL,
    FOREIGN KEY (id) REFERENCES abstract_condition (id) ON DELETE CASCADE ON UPDATE CASCADE DEFERRABLE INITIALLY DEFERRED
);
CREATE TABLE model
(
    id INTEGER PRIMARY KEY,
    code TEXT,
    name TEXT
);
CREATE TABLE model_attr
(
    id INTEGER PRIMARY KEY NOT NULL,
    code TEXT NOT NULL,
    name TEXT NOT NULL,
    attr_group_id INTEGER,
    FOREIGN KEY (attr_group_id) REFERENCES model_attr_group (id) ON DELETE CASCADE DEFERRABLE INITIALLY DEFERRED
);
CREATE TABLE model_attr_group
(
    id INTEGER PRIMARY KEY,
    model_id INTEGER NOT NULL,
    code TEXT NOT NULL,
    name TEXT NOT NULL,
    group_type TEXT,
    FOREIGN KEY (model_id) REFERENCES model (id) ON DELETE CASCADE DEFERRABLE INITIALLY DEFERRED
);
CREATE TABLE sqlite_sequence
(
    name TEXT,
    seq TEXT
);
