package org.example;

import java.util.ArrayList;
import java.util.List;

public class Layer<T extends Mappable<?>> {

    private List<T> listOfElements;

    public Layer(List<T> listOfElements) {
        this.listOfElements = listOfElements;
    }

    public void addElement(T element) {
        this.listOfElements.add(element);
    }

    public List<T> getListOfElements() {
        return listOfElements;
    }

    public List<Object> renderLayer() {
        List<Object> outputList = new ArrayList<>();
      for (T element : this.getListOfElements()) {
          var renderedElement = element.render();
          outputList.add(renderedElement);
      }
      return outputList;
    }
}
