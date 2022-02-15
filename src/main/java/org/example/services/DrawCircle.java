package org.example.services;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

//@ApplicationScoped
//@Named("CIRCLE")
public class DrawCircle implements DrawShape {

  @Override
  public void draw() {
    System.out.println("Drawing a CIRCLE");
  }
}
