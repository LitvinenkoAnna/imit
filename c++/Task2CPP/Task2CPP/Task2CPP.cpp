// Task2CPP.cpp: определяет точку входа для консольного приложения.
//

#include "stdafx.h"
#include "RingBuffer.h"
#include "Iterator.h"
#include <iostream>

using namespace std;
int main()
{
	RingBuffer *ringB = new RingBuffer(5);
	ringB->addElement(1);
	ringB->addElement(2);
	ringB->addElement(3);
	RingBuffer *ringA = new RingBuffer(*ringB);
	ringA->addElement(0);
	ringA->addElement(4);
	if (!ringA->checkEmpty()) {
		cout << "queue isn't empty" << endl;
	}
	Iterator iterator = Iterator(ringB);
	while (!iterator.finish()) {
		cout << iterator.getValue() << endl;
		iterator.next();
	}

	system("pause");
    return 0;
}

