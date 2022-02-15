package org.example.requests;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Inject;
import org.example.services.DrawShape;

@ApplicationScoped
public class SquareRequest {

  @Inject
//  @Named("PRODUCER")
  DrawShape getDrawShape;

  @Produces
  private String shape = "CIRCLE";

//  @Inject
//  public SquareRequest(DrawShape drawShape) {
//    this.drawShape = drawShape;
//  }

  public void makeRequest() {
    getDrawShape.draw();
  }

}
