package org.example.modules;

import com.google.inject.AbstractModule;
import org.example.services.DrawShape;
import org.example.services.DrawSquare;

public class DrawSquareModule extends AbstractModule {

  protected void configure() {
    bind(DrawShape.class).to(DrawSquare.class);
  }
}
