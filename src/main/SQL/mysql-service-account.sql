CREATE USER 'springdevops'@'localhost' IDENTIFIED BY 'dojo';

GRANT SELECT ON springdevopsdojo.* to 'springdevops'@'localhost';
GRANT INSERT ON springdevopsdojo.* to 'springdevops'@'localhost';
GRANT DELETE ON springdevopsdojo.* to 'springdevops'@'localhost';
GRANT UPDATE ON springdevopsdojo.* to 'springdevops'@'localhost';


CREATE USER 'qa2user'@'localhost' IDENTIFIED BY 'qa2password';

GRANT SELECT ON qa2.* to 'qa2user'@'localhost';
GRANT INSERT ON qa2.* to 'qa2user'@'localhost';
GRANT DELETE ON qa2.* to 'qa2user'@'localhost';
GRANT UPDATE ON qa2.* to 'qa2user'@'localhost';