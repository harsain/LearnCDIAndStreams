package org.example.services;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Inject;

@ApplicationScoped
public class DrawStrategy {

  @Inject
  private String shape;

//  public DrawStrategy(String shape) {
//    this.shape = shape;
//  }

  @Produces
//  @Named("PRODUCER")
  public DrawShape getDrawShape() {
    if ("SQUARE".equals(this.shape)) {
      return new DrawSquare();
    }
    return new DrawCircle();
  }
}
