#include "stdafx.h"
#include "BufferList.h"


BufferList::BufferList()
{
	size = 0;
	head = new Node(0);
	head->next = head;
	head->prev = head;
}


BufferList::~BufferList()
{
	makeEmpty();
	delete head; 
}

BufferList::ListIterator::ListIterator(BufferList * list)
{
	this->list = list;
	this->nowPointer = list->head;
}

void BufferList::ListIterator::start()
{
	nowPointer = list->head;
}

TElem BufferList::ListIterator::getElement() const
{
	if (nowPointer == list->head) {
		throw BufferException();
	}
	return nowPointer->data;
}

void BufferList::ListIterator::next()
{
	nowPointer = nowPointer->next;
}

void BufferList::ListIterator::prev()
{
	nowPointer = nowPointer->prev;
}

bool BufferList::ListIterator::finish() const
{
	if (nowPointer->next == list->head) {
		return true;
	}
	return false;
}

Node * BufferList::ListIterator::getNow() const
{
	return  nowPointer;
}


void BufferList::addElem(const TElem & elem, Iterator & iter)
{
	size++;
	Node *tempNode = new Node(elem, iter.getNow()->next, iter.getNow());
	iter.getNow()->next->prev = tempNode;
	iter.getNow()->next = tempNode;
}

void BufferList::deleteElem(Iterator & iter)
{
	if (iter.getNow() == head) {
		throw BufferException();
	}
	Node* delElem = iter.getNow();
	iter.next();
	delElem->next->prev = delElem->prev;
	delElem->prev->next = delElem->next;
	delete delElem;
	size--;
}

void BufferList::makeEmpty()
{
	head = head->next;
	for (int i = 0; i < size; i++) {
		head = head->next;
		delete head->prev;
	}
	head->next = head;
	head->prev = head;
	size = 0;
}

bool BufferList::isEmpty() const
{
	if (size == 0) {
		return true;
	}
	return false;
}

int BufferList::getSize() const
{

	return size;
}

Iterator * BufferList::findElem(const TElem & elem)
{
	ListIterator* listIterator = new ListIterator(this);
	while (listIterator->getElement() != elem && !listIterator->finish()) {
		
		listIterator->next();
	}
	if (listIterator->getElement() != elem) {
		throw NoElemException();
	}
	return listIterator;
}

Iterator * BufferList::getIterator()
{
	return new ListIterator(this);
}
