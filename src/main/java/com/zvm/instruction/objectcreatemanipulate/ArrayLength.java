package com.zvm.instruction.objectcreatemanipulate;

import com.zvm.instruction.Instruction;
import com.zvm.interpreter.CallSite;
import com.zvm.interpreter.CodeUtils;
import com.zvm.interpreter.Interpreter;
import com.zvm.memory.ArrayFields;
import com.zvm.runtime.*;
import com.zvm.runtime.struct.JObject;

public class ArrayLength implements Instruction {
    @Override
    public void execute(RunTimeEnv runTimeEnv, JThread jThread, JavaClass javaClass, CallSite callSite, Interpreter interpreter, CodeUtils code) {
        JavaFrame javaFrame = jThread.getTopFrame();
        OperandStack operandStack = javaFrame.operandStack;
        LocalVars localVars = javaFrame.localVars;

        JObject arrayJObject = operandStack.popJObject();
        ArrayFields arrayFields = runTimeEnv.javaHeap.arrayContainer.get(arrayJObject.offset);
        int size = arrayFields.arraySize;
        operandStack.putInt(size);
    }

}
