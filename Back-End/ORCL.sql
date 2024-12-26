create table PowerPlant(
  PlantID number primary key,
  Type varchar2(50),
  Name varchar2(50),
  Capacity number,
  Location varchar2(50),
  ContactInfo varchar2(10)
);

create table Substation(
  SubstationID number primary key,
  PlantID number,
  Name varchar2(50),
  Capacity number,
  Location varchar2(50),
  ContactInfo varchar2(10),
  Voltage number
);

create table Transformer(
  TransformerID number primary key,
  SubstationID number,
  Type varchar2(50),
  Capacity number,
  Location varchar2(50),
  VIn number,
  VOut number
);

create table MaintenanceLog(
  LogID number primary key,
  TransformerID number,
  Description varchar2(200),
  Issue varchar2(100),
  TechID number
);

create table Billing(
  BillID number primary key,
  UserID number,
  PayBy timestamp,
  Amount number,
  MeterID number
);

create table Technician(
  TechID number primary key,
  Name varchar2(50),
  Position varchar2(50)
);

create table UsageMeter(
  MeterID number primary key,
  UserID number,
  Type varchar2(100),
  LastReading decimal(10,2),
  LastReadingOn date
);

create table RegisteredUser(
  UserID number primary key,
  Name varchar2(50),
  ContactInfo varchar2(10)
);

create table ComplaintTicket(
  TicketID number primary key,
  UserID number,
  Issue varchar2(200),
  RecordedTime timestamp
);

-- foreign key constraint as fk_<a><b> where the key in a references b
alter table Substation add constraint fk_SsPp foreign key(PlantID) references PowerPlant(PlantID);
alter table Transformer add constraint fk_TfSs foreign key(SubstationID) references Substation(SubstationID);
alter table MaintenanceLog add constraint fk_MlTf foreign key(TransformerID) references Transformer(TransformerID);
alter table MaintenanceLog add constraint fk_MlTn foreign key(TechID) references Technician(TechID);
alter table Billing add constraint fk_BlRu foreign key(UserID) references RegisteredUser(UserID);
alter table Billing add constraint fk_BlUm foreign key(MeterID) references UsageMeter(MeterID);
alter table UsageMeter add constraint fk_UmRu foreign key(UserID) references RegisteredUser(UserID);
alter table ComplaintTicket add constraint fk_CtRu foreign key(UserID) references RegisteredUser(UserID);

-- check constraint as ck_<a><b> where b is the column in a
alter table PowerPlant drop constraint ck_PpCi;
alter table Substation drop constraint ck_SsCi;
alter table RegisteredUser drop constraint ck_RuCi;
alter table PowerPlant add constraint ck_PpCp check(Capacity>0);
alter table Substation add constraint ck_SsCp check(Capacity>0);
alter table Transformer add constraint ck_TfCp check(Capacity>0);