<template>
  <div class="home">
    <MdEditor :value="value" :handle-change="onContentChange" />
    <CodeEditor></CodeEditor>
    <img alt="Vue logo" src="../assets/logo.png" />
    <HelloWorld msg="Welcome to Your Vue.js + TypeScript App" />
  </div>
</template>

<script lang="ts" setup>
import { defineComponent, ref } from "vue";
import HelloWorld from "@/components/HelloWorld.vue";
import MdEditor from "@/components/MdEditor.vue";
import CodeEditor from "@/components/CodeEditor.vue"; // @ is an alias to /src

const value = ref();

const onContentChange = (v: string) => {
  value.value = v;
};
defineComponent({
  name: "HomeView",
  components: {
    MdEditor,
    HelloWorld,
  },
});
</script>
