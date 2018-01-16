
DROP TABLE IF EXISTS GREETING;

CREATE TABLE GREETING (
  ID              BIGSERIAL,
  MESSAGE         TEXT,
  GREETING_TIME   TIMESTAMP,
  CONSTRAINT GREETING_PK PRIMARY KEY(ID)
);