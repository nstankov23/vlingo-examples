package com.skyharbor.fleetcrew.infrastructure.persistence;

import io.vlingo.xoom.annotation.persistence.Persistence;
import io.vlingo.xoom.annotation.persistence.Persistence.StorageType;
import io.vlingo.xoom.annotation.persistence.Projections;
import io.vlingo.xoom.annotation.persistence.Projection;
import io.vlingo.xoom.annotation.persistence.Adapters;
import io.vlingo.xoom.annotation.persistence.EnableQueries;
import io.vlingo.xoom.annotation.persistence.QueriesEntry;
import io.vlingo.xoom.annotation.persistence.DataObjects;
import com.skyharbor.fleetcrew.model.aircraft.ArrivalRecorded;
import com.skyharbor.fleetcrew.infrastructure.AircraftData;
import com.skyharbor.fleetcrew.model.aircraft.DepartureRecorded;
import com.skyharbor.fleetcrew.model.aircraft.AircraftState;
import com.skyharbor.fleetcrew.model.aircraft.ArrivalPlanned;

@Persistence(basePackage = "com.skyharbor.fleetcrew", storageType = StorageType.STATE_STORE, cqrs = true)
@Projections({
  @Projection(actor = AircraftProjectionActor.class, becauseOf = {DepartureRecorded.class, ArrivalRecorded.class, ArrivalPlanned.class})
})
@Adapters({
  AircraftState.class
})
@EnableQueries({
  @QueriesEntry(protocol = AircraftQueries.class, actor = AircraftQueriesActor.class),
})
@DataObjects({AircraftData.class})
public class PersistenceSetup {


}