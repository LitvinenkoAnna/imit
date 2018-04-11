// Task2CPP.cpp: определяет точку входа для консольного приложения.
//

#include "stdafx.h"
struct SizeException {};
class RingBuffer {
private:
	double *arr;
	int size;
	int firstPointer;
	int lastPointer;
public:
	RingBuffer(int size) {
		arr = new double[size];
		this->size = size;
		firstPointer = 0;
		lastPointer = 0;
	}
	RingBuffer(const RingBuffer &copy) {
		this->size = copy.size;
		arr = new double[copy.size];
		for (int i = 0; i < size; i++) {
			arr[i] = copy.arr[i];
		}
	}
	void addElement(double element) {
		if (lastPointer == firstPointer) {
			throw SizeException();
		 }
		arr[lastPointer] = element;
		lastPointer++;
		lastPointer = lastPointer%size;
	}
};

int main()
{
    return 0;
}

