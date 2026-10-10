#include <stdio.h>
#include <stdlib.h>

struct Node {
    int data;
    struct Node *next;
};

struct Node* createNode(int data) {
    struct Node *newNode =
        (struct Node*)malloc(sizeof(struct Node));

    newNode->data = data;
    newNode->next = NULL;

    return newNode;
}

void findNodeFromLast(struct Node *head, int position) {

    struct Node *first = head;
    struct Node *second = head;

    for (int i = 0; i < position; i++) {
        if (first == NULL) {
            printf("Invalid Position\n");
            return;
        }
        first = first->next;
    }

    while (first != NULL) {
        first = first->next;
        second = second->next;
    }

    printf("%dth Node from Last = %d\n", position, second->data);
}

int main() {

    struct Node *head = createNode(10);
    head->next = createNode(20);
    head->next->next = createNode(30);
    head->next->next->next = createNode(40);
    head->next->next->next->next = createNode(50);

    findNodeFromLast(head, 2);

    return 0;
}