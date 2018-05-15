package TestClasses;

import java.util.Iterator;

public class DataIterator implements Iterator<Integer> {

    private int index;
    private Data dataObj;


    public DataIterator(Data dataObj) {
        this.index = -1;
        this.dataObj = new Data(dataObj);
    }

    public DataIterator(DataIterator copy) {
        this.index = copy.index;
        this.dataObj = new Data(copy.dataObj);
    }

    public boolean hasNext() {
        int sizeLocale = 0;
        for (Group group : dataObj.getGroups()) {
            sizeLocale += group.getLength();
        }
        return index + 1 < sizeLocale;
    }

    public Integer next() {
        int tempIndex = 0, bufIndex;
        index++;
        bufIndex = index;
        while (bufIndex >= dataObj.getGroups()[tempIndex].getLength()) {
            bufIndex -= dataObj.getGroups()[tempIndex].getLength();
            tempIndex++;
        }
        return dataObj.getGroups()[tempIndex].getArrayInt()[bufIndex];
    }

    public void remove() {
        int tempIndex = 0, bufIndex;
        bufIndex = index;
        while (bufIndex >= dataObj.getGroups()[tempIndex].getLength()) {
            tempIndex++;
            bufIndex -= dataObj.getGroups()[tempIndex].getLength();
        }
        int[] temp = new int[dataObj.getGroups()[tempIndex].getArrayInt().length-1];

        for(int i = 0; i < bufIndex; i++) {
            temp[i]=dataObj.getGroups()[tempIndex].getArrayInt()[i];
        }
        for(int i = bufIndex+1; i < dataObj.getGroups()[tempIndex].getArrayInt().length; i++) {
            temp[i]=dataObj.getGroups()[tempIndex].getArrayInt()[i];
        }
        dataObj.getGroups()[tempIndex].setArrayInt(temp);
    }

}
