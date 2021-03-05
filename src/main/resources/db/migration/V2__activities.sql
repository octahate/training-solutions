create table activities(id bigint AUTO_INCREMENT, startTime DATETIME, activity_desc varchar(255), activity_type VARCHAR(255), primary key(id));
create table track_point(id bigint, time DATETIME, lat double, lon double, FOREIGN KEY (id) REFERENCES activities(id));
