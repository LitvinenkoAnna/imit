#include "stdafx.h"
#include "Iterator.h"

Iterator::Iterator(RingBuffer* &que) {
	this->index = 0;
	this->queue = que;
}
void Iterator::start() {
	index = 0;

}
void Iterator::next() {
	index++;
	index = index%queue->size;
}

bool Iterator::finish() {
	if (queue->lastPointer+1 == index) {
		return true;
	}
	return false;

}
int Iterator::getValue() {
	return queue->arr[index];
}