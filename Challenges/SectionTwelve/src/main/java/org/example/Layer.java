package org.example;

import java.util.ArrayList;
import java.util.List;

public class Layer<T extends Mappable<?>> {

    private List<T> elements;

    public Layer(List<T> listOfElements) {
        this.elements = listOfElements;
    }

    public void addElement(T element) {
        this.elements.add(element);
    }

    public List<T> getListOfElements() {
        return elements;
    }

    public List<Object> renderLayer() {
        List<Object> outputList = new ArrayList<>();
      for (T element : this.getListOfElements()) {
          var renderedElement = element.render();
          outputList.add(renderedElement);
      }
      return outputList;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T element : this.elements) {
            sb.append(element.toString()).append("\n");
        }
        return sb.toString();
    }
}
