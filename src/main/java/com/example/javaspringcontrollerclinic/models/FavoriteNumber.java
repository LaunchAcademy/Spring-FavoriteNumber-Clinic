package com.example.javaspringcontrollerclinic.models;

import org.springframework.stereotype.Component;

@Component
public class FavoriteNumber {
  private int number;

  public int getNumber() {
    return number;
  }

  public void setNumber(int number) {
    this.number = number;
  }

  public boolean getIsOdd() {
    return number % 2 != 0;
  }
}
