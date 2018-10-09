function Node(value) {
    this.data = value;
    this.previous = null;
    this.next = null;
}

function DoublyList() {
    this._length = 0;
    this.head = null;
    this.tail = null;
}

DoublyList.prototype.add = function (value) {
    var node = new Node(value);

    if (this._length) {
        this.tail.next = node;
        node.previous = this.tail;
        this.tail = node;
    } else {
        this.head = node;
        this.tail = node;
    }

    this._length++;

    return node;
};

DoublyList.prototype.searchNodeAt = function (position) {
    var currentNode = this.head,
        length = this._length,
        count = 1,
        message = {
            failure: 'Failure: non-existent node in this list.'
        };

    // an invalid position
    if (length === 0 || position < 1 || position > length) {
        throw new Error(message.failure);
    }

    //a valid position
    while (count < position) {
        currentNode = currentNode.next;
        count++;
    }

    return currentNode;
};

DoublyList.prototype.remove = function (position) {
    var currentNode = this.head,
        length = this._length,
        count = 1,
        message = {
            failure: 'Failure: non-existent node in this list.'
        },
        beforeNodeToDelete = null,
        nodeToDelete = null,
        deletedNode = null;

    // an invalid position
    if (length === 0 || position < 1 || position > length) {
        throw new Error(message.failure);
    }

    // the first node is removed
    if (position === 1) {
        this.head = currentNode.next;

        // there is a second node
        if (!this.head) {
            this.head.previous = null;
            // there is no second node
        } else {
            this.tail = null;
        }

        // the last node is removed
    } else if (position === this._length) {
        this.tail = this.tail.previous;
        this.tail.next = null;
        // a middle node is removed
    } else {
        while (count < position) {
            currentNode = currentNode.next;
            count++;
        }

        beforeNodeToDelete = currentNode.previous;
        nodeToDelete = currentNode;
        afterNodeToDelete = currentNode.next;

        beforeNodeToDelete.next = afterNodeToDelete;
        afterNodeToDelete.previous = beforeNodeToDelete;
        deletedNode = nodeToDelete;
        nodeToDelete = null;
    }

    this._length--;

    return message.success;
};
