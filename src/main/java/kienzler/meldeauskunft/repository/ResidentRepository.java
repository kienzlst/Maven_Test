package kienzler.meldeauskunft.repository;

import java.util.List;

import kienzler.meldeauskunft.domain.Resident;

/**
 * @author Stefan Betermieux
 */
public interface ResidentRepository {

  List<Resident> getResidents();

}