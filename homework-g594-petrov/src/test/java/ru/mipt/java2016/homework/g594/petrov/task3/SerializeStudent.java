package ru.mipt.java2016.homework.g594.petrov.task3;

import ru.mipt.java2016.homework.tests.task2.Student;

import java.io.DataInputStream;
import java.io.RandomAccessFile;
import java.util.Date;

/**
 * Created by philipp on 14.11.16.
 */

public class SerializeStudent implements InterfaceSerialization<Student> {
    @Override
    public void writeValue(Student obj, RandomAccessFile outputStream) throws IllegalStateException {
        try {
            outputStream.writeInt(obj.getGroupId());
            outputStream.writeUTF(obj.getName());
            outputStream.writeUTF(obj.getHometown());
            outputStream.writeLong(obj.getBirthDate().getTime());
            outputStream.writeBoolean(obj.isHasDormitory());
            outputStream.writeDouble(obj.getAverageScore());
        } catch (Exception e) {
            throw new IllegalStateException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public Student readValue(RandomAccessFile inputStream) throws IllegalStateException {
        try {
            int studentGroup = inputStream.readInt();
            String studentName = inputStream.readUTF();
            String studentHometown = inputStream.readUTF();
            Date studentDate = new Date(inputStream.readLong());
            return new Student(studentGroup, studentName, studentHometown, studentDate,
                    inputStream.readBoolean(), inputStream.readDouble());
        } catch (Exception e) {
            throw new IllegalStateException(e.getMessage(), e.getCause());
        }
    }
}

