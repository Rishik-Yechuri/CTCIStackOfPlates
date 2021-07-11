import java.util.ArrayList;
import java.util.Stack;

public class CTCIStackOfPlates {
    public static void main(String[] args) {
        try {
            CTCIStackOfPlates obj = new CTCIStackOfPlates();
            obj.run(args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void run(String[] args) throws Exception {
        SetOfStacks manyStacks = new SetOfStacks();
        manyStacks.push(5);
        manyStacks.push(4);
        manyStacks.push(3);
        manyStacks.push(2);
        manyStacks.push(1);
        manyStacks.push(6);
        manyStacks.push(7);
        System.out.println(manyStacks.pop());
        manyStacks.push(19);
        manyStacks.push(18);
        manyStacks.push(17);
        manyStacks.push(16);
        manyStacks.push(15);
        manyStacks.popAt(0);
        System.out.println(manyStacks.pop());
        System.out.println(manyStacks.pop());
        System.out.println(manyStacks.pop());
        System.out.println(manyStacks.pop());
        System.out.println(manyStacks.pop());
        System.out.println(manyStacks.pop());
        System.out.println(manyStacks.pop());
        System.out.println(manyStacks.pop());
    }

    class SetOfStacks {
        ArrayList<Stack> holdStacks = new ArrayList<>();
        Stack currentStack = null;
        int elementsInStack = 0;
        int indexOfStack = 0;
        int popIndexOfStack = 0;

        SetOfStacks() {
            holdStacks.add(new Stack());
            currentStack = holdStacks.get(0);
        }

        public void push(int data) {
            if (elementsInStack + 1 <= 5) {
                elementsInStack++;
            } else {
                boolean stackFound = false;
                while (!stackFound) {
                    indexOfStack++;
                    popIndexOfStack++;
                    if (indexOfStack > holdStacks.size() - 1) {
                        holdStacks.add(new Stack());
                    }
                    currentStack = holdStacks.get(indexOfStack);
                    if (currentStack.size() < 5) {
                        stackFound = true;
                        //elementsInStack = currentStack.size();
                    }
                }
            }
            currentStack.push(data);
            elementsInStack = currentStack.size();
        }

        public int pop() {
            if (elementsInStack - 1 >= 0) {
                elementsInStack--;
            } else {
                holdStacks.remove(popIndexOfStack);
                elementsInStack = 0;
                if (popIndexOfStack != 0) {
                    elementsInStack = 4;
                    if(indexOfStack == popIndexOfStack){
                        indexOfStack--;
                    }
                    popIndexOfStack--;
                    currentStack = holdStacks.get(popIndexOfStack);
                } else {
                    return 0;
                }
            }
            return (int) currentStack.pop();
        }

        public int popAt(int index) {
            int tempElementsInStack = holdStacks.get(index).size();
             if(!(tempElementsInStack - 1 >= 0)) {
                holdStacks.remove(index);
                if (index != 0) {
                    index--;
                    if (index == holdStacks.size() - 1) {
                        popIndexOfStack--;
                    }
                    //currentStack = holdStacks.get(index);
                } else {
                    return 0;
                }
            }
            Stack tempStack = holdStacks.get(index);
            indexOfStack = index;
            return (int) tempStack.pop();
        }
    }
}
