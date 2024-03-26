<script setup>
  import { useRouter } from 'vue-router';
  import { reactive, onMounted } from 'vue';

  const props = defineProps({});

  const data = reactive({
    email: '',
    password: '',
  });

  const router = useRouter();

  const navigateToIndexPage = () => {
    const email = data.email
    const password = data.password
    router.push({
      path: '/index',
      query: { email, password }
    })
  }
</script>

<template>
  <div class="flex-col page">
    <span class="self-start text">Welcome Back!</span>
    <div class="flex-col self-stretch group">
      <div class="flex-col">
        <span class="self-start font">Email</span>
        <el-input class="input mt-7 elinput" v-model="data.email"></el-input>
      </div>
      <div class="mt-10 flex-col">
        <span class="self-start font">Password</span>
        <el-input class="input mt-7 elinput_1" v-model="data.password" type="password"></el-input>
      </div>
    </div>
    <span class="self-center font_2 text_4">Forgot your password？</span>
    <div class="flex-col justify-start items-center self-center text-wrapper_3" @click="navigateToIndexPage">
      <span class="text_5">Login in</span>
    </div>
  </div>
</template>

<style scoped lang="css">
  .mt-7 {
    margin-top: 0.44rem;
  }
  .page {
    padding: 4.13rem 1.13rem 26.75rem 1.13rem;
    width: 100%;
    overflow-y: auto;
    overflow-x: hidden;
    height: 100%;
  }
  .text {
    color: rgb(0, 0, 0);
    font-size: 1.31rem;
    font-family: 'Heiti SC';
    font-weight: 700;
    line-height: 1.31rem;
  }
  .group {
    margin-top: 2.69rem;
  }
  .font {
    font-size: 1rem;
    font-family: 'Heiti SC';
    line-height: 1rem;
    font-weight: 700;
    color: rgb(0, 0, 0);
  }
  .input {
    align-self: stretch;
  }
  .font_2 {
    font-size: 1rem;
    font-family: 'Heiti SC';
    line-height: 1rem;
    font-weight: 700;
    color: rgb(151, 151, 151);
  }
  .text_4 {
    margin-top: 2.06rem;
    font-size: 0.88rem;
    line-height: 0.88rem;
  }
  .text-wrapper_3 {
    margin-top: 1.81rem;
    padding: 1rem 0 0.94rem;
    background-color: rgb(0, 0, 0);
    width: 12.56rem;
  }
  .text_5 {
    color: rgb(255, 255, 255);
    font-size: 0.88rem;
    font-family: 'Heiti SC';
    font-weight: 700;
    line-height: 0.88rem;
  }
</style>