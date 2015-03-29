--<ScriptOptions statementTerminator=";"/>

CREATE TABLE PEUGEOT.MODELS (ID INTEGER NOT NULL,
    malli VARCHAR(20),
    korityyppi VARCHAR(20),
    moottori VARCHAR(20),
    info VARCHAR(200),
     PRIMARY KEY (ID)
    
    ); 
    
    
  INSERT INTO PEUGEOT.MODELS VALUES (1,'308','SW','1.6','ON VUODEN 2014 AUTO');