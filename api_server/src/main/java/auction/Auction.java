package auction;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import bid.Bid;
import dog.DogDao;

public class Auction {

  private Integer id;
  private Integer dogId;
  private Instant expirationTime;
  private Double startPrice;
  private String name;
  private Boolean completed = false;
  private Bid highestBid;

  public Auction() {}
  public Auction(Integer dogId, Instant expirationTime, Double startPrice, String name, Boolean completed) {
    this.dogId = dogId;
    this.expirationTime = expirationTime;
    this.startPrice = startPrice;
    this.name = name;
    this.completed = completed;
  }

  public Auction(Integer id, Integer dogId, Instant expirationTime, Double startPrice, String name, Boolean completed) {
    this.id = id;
    this.dogId = dogId;
    this.expirationTime = expirationTime;
    this.startPrice = startPrice;
    this.name = name;
    this.completed = completed;
  }

  /**
   * @return the id
   */
  public Integer getId() {
    return id;
  }

  /**
   * @param id the id to set
   */
  public void setId(Integer id) {
    this.id = id;
  }

  /**
   * @return the dogId
   */
  public Integer getDogId() {
    return dogId;
  }

  /**
   * @param dogId the dogId to set
   */
  public void setDogId(Integer dogId) {
    this.dogId = dogId;
  }

  /**
   * @return the expirationTime
   */
  public Instant getExpirationTime() {
    return expirationTime;
  }

  /**
   * @param expirationTime the expirationTime to set
   */
  public void setExpirationTime(Instant expirationTime) {
    this.expirationTime = expirationTime;
  }

  /**
   * @return the startPrice
   */
  public Double getStartPrice() {
    return startPrice;
  }

  /**
   * @param startPrice the startPrice to set
   */
  public void setStartPrice(Double startPrice) {
    this.startPrice = startPrice;
  }

    /**
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * @param name the name to set
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * @return the completed
   */
  public Boolean getCompleted() {
    return completed;
  }

  /**
   * @param completed the completed to set
   */
  public void setCompleted(Boolean completed) {
    this.completed = completed;
  }

  public void setHighestBid(Bid highestBid) {
    this.highestBid = highestBid;
  }

  /**
   * Update an Auction with the non-null fields of a newer Auction.
   * @param updatedAuction The Auction containing fields to be applied to the existing Auction.
   */
  public void update(Auction updatedAuction) {

    if (updatedAuction.id != null)
      this.id = updatedAuction.id;

    if (updatedAuction.dogId != null)
      this.dogId = updatedAuction.dogId;

    if (updatedAuction.name != null)
      this.name = updatedAuction.name;

    if (updatedAuction.expirationTime != null)
      this.expirationTime = updatedAuction.expirationTime;

    if (updatedAuction.startPrice != null)
      this.startPrice = updatedAuction.startPrice;

    if (updatedAuction.completed != null)
      this.completed = updatedAuction.completed;
  }

  public List<String> validate() {
    List<String> errors = new ArrayList<>();
    if (this.dogId == null)
      errors.add("dogId is null");
    else if (new DogDao().get(this.dogId) == null)
      errors.add("no dog matching id: " + this.dogId.toString());

    if (this.expirationTime == null)
      errors.add("expirationTime is null");
    else if (this.expirationTime.isBefore(Instant.now()))
      errors.add("expirationTime is invalid");

    if (this.startPrice == null)
      errors.add("startPrice is null");
    else if (this.startPrice < 0.0)
      errors.add("startPrice is invalid");

    if (this.name == null)
      errors.add("name is null");

    return errors;
  }
}
