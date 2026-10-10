#include <stdio.h>
#include <stdlib.h>

struct Node {
    int data;
    struct Node *next;
    struct Node *prev;
};

struct Node* createNode(int data) {

    struct Node *newNode =
        (struct Node*)malloc(sizeof(struct Node));

    newNode->data = data;
    newNode->next = NULL;
    newNode->prev = NULL;

    return newNode;
}

// Insert Node at Kth Position
struct Node* insertAtPosition(struct Node *head, int data, int position) {

    struct Node *newNode = createNode(data);

    // Insert at first position
    if (position == 1) {

        newNode->next = head;

        if (head != NULL) {
            head->prev = newNode;
        }

        head = newNode;

        return head;
    }

    struct Node *temp = head;

    // Move to the Node before required position
    for (int i = 1; i < position - 1 && temp != NULL; i++) {
        temp = temp->next;
    }

    // Invalid position
    if (temp == NULL) {
        printf("Invalid position\n");
        free(newNode);
        return head;
    }

    // Connect new Node
    newNode->next = temp->next;
    newNode->prev = temp;

    // Update next Node's prev
    if (temp->next != NULL) {
        temp->next->prev = newNode;
    }

    // Update previous Node's next
    temp->next = newNode;

    return head;
}

// Display Linked List
void traverse(struct Node *head) {

    struct Node *temp = head;

    while (temp != NULL) {

        printf("%d ", temp->data);

        temp = temp->next;
    }
}

int main() {

    struct Node *head = createNode(10);

    head->next = createNode(20);
    head->next->prev = head;

    head->next->next = createNode(30);
    head->next->next->prev = head->next;

    // Insert 15 at position 2
    head = insertAtPosition(head, 15, 2);

    traverse(head);

    return 0;
}