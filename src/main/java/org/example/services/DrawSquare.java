package org.example.services;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

//@ApplicationScoped
//@Named("SQUARE")
public class DrawSquare implements DrawShape {

  @Override
  public void draw() {
    System.out.println("Drawing a SQUARE");
  }
}
