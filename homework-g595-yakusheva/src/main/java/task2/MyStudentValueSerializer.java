package task2;

import jdk.nashorn.internal.parser.DateParser;
import ru.mipt.java2016.homework.tests.task2.Student;

import java.io.*;
import java.sql.Date;

/**
 * Created by Софья on 27.10.2016.
 */
public class MyStudentValueSerializer implements MyFirstSerializerInterface<Student> {
    @Override
    public void serializeToStream(DataOutputStream dataOutputStream, Student o) throws IOException {

        dataOutputStream.writeInt(o.getGroupId());
        dataOutputStream.writeUTF(o.getName());
        dataOutputStream.writeUTF(o.getHometown());
        dataOutputStream.writeLong((o.getBirthDate()).getTime());
        dataOutputStream.writeBoolean(o.isHasDormitory());
        dataOutputStream.writeDouble(o.getAverageScore());
    }

    @Override
    public Student deserializeFromStream(DataInputStream dataInputStream) throws IOException {
        return new Student(dataInputStream.readInt(), dataInputStream.readUTF(), dataInputStream.readUTF(), new Date(dataInputStream.readLong()),
                dataInputStream.readBoolean(), dataInputStream.readDouble());
    }
}
