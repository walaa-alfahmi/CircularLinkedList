#include <iostream>
using namespace std;
/**
 *
 * @author Walaa Alfahmi
 */
struct Node
{
    int data;
    Node *next;
    Node(int val = 0) : data(val), next(nullptr) {}
    Node(int val, Node *tempNext) : data(val), next(tempNext) {}
};

class CircularLinkedList
{

public:
    Node *tail;
    int size;
    CircularLinkedList() : tail(nullptr), size(0)
    {
    }

    void addFirst(int val)
    {
        Node *newest = new Node(val);
        if (tail == nullptr)
        {
            newest->next = newest;
            tail = newest;
            tail->next = newest;
        }
        else
        {
            newest->next = tail->next;
            tail->next = newest;
        }
        size++;
    }
    void insert(int val)
    {
        Node *newest = new Node(val);

        if (tail == nullptr)
        {
            newest->next = newest;
            tail = newest;
            size++;
        }
        else if (newest->data < tail->next->data)
        {
            addFirst(val);
        }
        else
        {
            Node *c = tail->next;
            while (c->next != tail->next && newest->data > c->next->data)
            {
                c = c->next;
            }
            if (newest->data > c->next->data)
            {
                addLast(val);
            }
            else
            {
                newest->next = c->next;
                c->next = newest;
                size++;
            }
        }
    }

    void addLast(int val)
    {
        addFirst(val);
        tail = tail->next;
    }

    void removeFirst()
    {
        if (tail != nullptr)
        {
            if (tail->next == tail)
            {
                tail = nullptr;
                size--;
            }
            else
            {
                Node *temp = tail->next;
                tail->next = temp->next;
                size--;
            }
        }
    }

    void remove(int val)
    {
        if (tail != nullptr)
        {
            if (tail->next != nullptr && tail->next->data == val)
            {
                removeFirst();
            }
            else
            {
                Node *c = tail->next;
                while (c->next != tail->next && c->next->data != val)
                {
                    c = c->next;
                }
                if (c->next != tail->next)
                {
                    Node *temp = c->next;
                    c->next = temp->next;
                    size--;
                }
            }
        }
    }

    void removeLast()
    {
        if (tail != nullptr)
        {
            if (tail->next == tail)
            {
                tail->next = nullptr;
                tail = nullptr;
                size--;
            }
            else
            {
                Node *secondLast = tail->next;
                Node *last = secondLast->next;
                while (last->next != tail->next)
                {
                    secondLast = secondLast->next;
                    last = last->next;
                }
                secondLast->next = tail->next;
                tail = secondLast;
                size--;
            }
        }
    }

    void display()
    {
        if (tail != nullptr)
        {
            Node *temp = tail->next;

            cout << "head = " << tail->next->data << ", tail = " << tail->data << "\n";

            do
            {
                cout << temp->data << " ";
                temp = temp->next;
            } while (temp != tail->next);
            cout << endl;
        }
    }
};

int main()
{
    CircularLinkedList cll;
    cll.addFirst(5);
    cll.addLast(10);

    cll.insert(1);
    cll.insert(100);
    cll.insert(7);

    cll.display();

    cll.removeFirst();
    cll.removeLast();

    cll.display();

    cll.remove(7);
    cll.display();
    return 0;
}