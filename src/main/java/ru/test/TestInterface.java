package ru.test;

import ru.entity.ViewTest;

import java.io.IOException;

public interface TestInterface {
    ViewTest viewTest = new ViewTest();
    ViewTest test() throws IOException;
}
