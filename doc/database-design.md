# Telemetry Database Design 

## purpose 

The database will store equipment information and maintenance history. 
this will allow equipment to be added without changing main.java

## Equipment tabel

Each row represents one machine.

- id: A unique internal identifier for the machine. This is the primary key.
- equipment_code: The identifier an operator uses, such as CAT-001.
- model: The machine's model, such as 988k.
- current_engine_hours: The latest known engine-hour reading.
- service_interval_hours: The required hours between services.

### Rules

- Each equipment code must be unique and cannot be blank.
- The model cannot be blank.
- Current engine hours must be zero or greater.
- The service interval must be greater than zero.

## Service Records Table

Each row represents one completed maintenance event.

- id: A unique identifier for the service record. This is the primary key.
- equipment_id: Identifies the machine that received maintenance.
  This is a foreign key referencing the equipment table's id.
- engine_hours_at_service: The engine-hour reading when service occurred.
- serviced_at: The date and time the maintenance occurred.
- notes: Optional details about the maintenance.

### Rules

- Every service record must belong to an existing machine.
- Engine hours at service must be zero or greater.
- The service date and time are required.
- Adding a service record preserves previous service records.


## Relationship

One machine can have many service records.
Each service record belongs to one machine.

## Example

CAT-001 currently has 550 engine hours.
Its most recent service happened at 500 engine hours.
Its service interval is 250 hours.

Hours since service = 550 - 500 = 50.
Hours remaining = 250 - 50 = 200.

The machine has 200 hours remaining before maintenance is due.

## Initial Assumptions

- Each machine has one maintenance schedule.
- Engine-hour meters do not reset in this version.
- Missing maintenance history means the last service is unknown.
- The calculator performs calculations without querying the database.

## Implementation Status

This document describes the proposed design.
The database has not been implemented yet.

## First Database Milestone

Store equipment and its maintenance history in PostgreSQL.

### Acceptance Criteria

- Save one machine with a unique equipment code.
- Save two service records linked to that machine.
- Retrieve the machine and both service records.
- Retrieve its latest service by the serviced_at timestamp.
- Confirm the data remains after restarting the database.
- Reject duplicate equipment codes.
- Reject service records referencing nonexistent equipment.
- Reject negative engine hours and nonpositive service intervals.

### Outside This Milestone

- Connecting the Java application to the database.
- REST endpoints.
- User accounts and permissions.